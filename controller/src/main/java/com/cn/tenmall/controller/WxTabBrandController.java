package com.cn.tenmall.controller;


import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.service.BrandService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.UUID;


@RestController
@RequestMapping("/brand")
@CrossOrigin
public class WxTabBrandController {

    @Autowired
    private BrandService brandService;

    //    查询所有
    @RequestMapping("/findAll")
    public TenmallResult findAll() {
        TenmallResult tenmallResult = brandService.finAll();
        return tenmallResult;
    }

    //根据id查询数据
    @RequestMapping("findById")
    public TenmallResult findById(Integer id) {
        if (id == null) {
            return TenmallResult.build(1, "参数错误");
        }
        TenmallResult tenmallResult = brandService.findById(id);
        return tenmallResult;
    }

    // 分页查询&分页查询+条件查询
    @RequestMapping(value = "/findPage")
    public TenmallResult findPage(Integer page, Integer size, WxTabBrand searchMap) {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = streamReader.readLine()) != null) {
//                sb.append(line);
//            }
//            jsonObject = JSONObject.parseObject(sb.toString());
//        } catch (Exception e) {
//
//        }
//        System.out.println("数据："+jsonObject.get("page"));
//        System.out.println("数据1："+searchMap.getPage());
//        System.out.println("数据2："+page);
        if (page == null || page == 0 || size == null) {
            return TenmallResult.build(1, "参数错误");
        }
        TenmallResult tenmallResult = brandService.findPage(page, size, searchMap);
        return tenmallResult;
    }

    //修改
    @RequestMapping("/update")
    public TenmallResult update(WxTabBrand wxTabBrand) {
        TenmallResult updateResult = brandService.update(wxTabBrand);
        return updateResult;
    }

    //新增
    @RequestMapping("/add")
    public TenmallResult add(WxTabBrand wxTabBrand) {
        TenmallResult addResult = brandService.add(wxTabBrand);
        return addResult;
    }

    //删除
    @RequestMapping("/delete")
    public TenmallResult deleteById(Integer id) {
        if (id == null || id == 0) {
            return TenmallResult.build(1, "参数错误");
        }
        TenmallResult tenmallResult = brandService.deleteById(id);
        return tenmallResult;
    }

    //图片上传
    @RequestMapping("upload")
    public TenmallResult upload(@RequestParam(value = "imageDate", required = false) MultipartFile file) {
        String newCompanyImagepath = null;
        if (!file.isEmpty()) {
            try {
                //设置图片路径
                String imgFile = "imgs";
                //设置图片名称
                String picName = UUID.randomUUID().toString().replace("-", "");
                //获取后缀
                String filename = file.getOriginalFilename();
                String suffix = filename.substring(filename.lastIndexOf("."));
                //图片存储的路径
                String newMkdirs = "f://" + imgFile;
                //完整路径名称
                newCompanyImagepath = newMkdirs + "//" + picName + suffix;

                File newFile2 = new File("f://" + imgFile);
                if (newFile2.mkdirs()) {
                    System.out.println("创建一个文件夹");
                }
                File newFile1 = new File(newCompanyImagepath);
                if (!newFile1.exists()) {
                    newFile1.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile1));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return TenmallResult.build(0, "图片上传失败");
            }
        }
        return TenmallResult.ok(newCompanyImagepath);
    }

}
