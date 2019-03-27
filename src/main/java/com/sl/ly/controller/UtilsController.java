package com.sl.ly.controller;

import com.sl.ly.service.EvaluateService;
import com.sl.ly.utils.FileUtils;
import com.sl.ly.utils.RedisUtils;
import com.sl.ly.utils.SMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisCluster;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@Api(tags = "工具接口")
@RestController
@RequestMapping("/utils")
public class UtilsController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private JedisCluster jedisCluster;
    private static final String PATH_PREFIX = "poster/";
    private static final int TEMPLATE_ID = 143566;
    @Value("${spring.mail.username}")
    private String from;

    @ApiOperation("上传路演海报")
    @RequestMapping(value = "/imgUp/poster", method = RequestMethod.POST)
    public String imgUp(MultipartFile file) {
        return FileUtils.fileUP(file, PATH_PREFIX);
    }

    @ApiOperation("发送验证码")
    @RequestMapping(value = "/sendCode/{mobile}", method = RequestMethod.GET)
    public boolean registerCode(@PathVariable("mobile") String mobile) {
        redisUtils.del(mobile);
        String code = SMS.sendCode(mobile, TEMPLATE_ID);
        redisUtils.set(mobile, code, 300);
        Object o = redisUtils.get(mobile);
        System.out.println(o.toString());
        return true;
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public boolean sendCollect(String sponsorUUID, String to) throws IOException, MessagingException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("路演");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("路演汇总表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("项目名");
        row2.createCell(1).setCellValue("成绩");
        row2.createCell(2).setCellValue("名次");
        List<Map<String, Object>> collectList = evaluateService.getCollectList(sponsorUUID);
        int index = 2;
        System.out.println(collectList);
        for (Map<String, Object> item : collectList) {
            HSSFRow row3 = sheet.createRow(index);
            row3.createCell(0).setCellValue(item.get("projectName").toString());
            row3.createCell(1).setCellValue(item.get("total").toString());
            row3.createCell(2).setCellValue(index - 1);
        }
        ByteArrayOutputStream file = new ByteArrayOutputStream();
        wb.write(file);
        file.flush();
        byte[] bt = file.toByteArray();
        InputStream is = new ByteArrayInputStream(bt, 0, bt.length);
        file.close();
        wb.close();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText("感谢使用");
        ByteArrayDataSource dataSource = new ByteArrayDataSource(is, "application/msexcel");
        mimeMessageHelper.addAttachment("路演汇总.xls", dataSource);
        javaMailSender.send(mimeMessage);
        return true;
    }


}
