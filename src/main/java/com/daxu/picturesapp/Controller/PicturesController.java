package com.daxu.picturesapp.Controller;

import com.daxu.picturesapp.Service.PicturesService;
import com.daxu.picturesapp.Service.impl.PicturesServiceImpl;
import com.daxu.picturesapp.domain.Pictures;
import com.daxu.picturesapp.domain.Result;
import com.daxu.picturesapp.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PicturesController {
    private static final Logger logger = LoggerFactory.getLogger(PicturesController.class);
    @Autowired
    private PicturesService picturesService;
    @RequestMapping("allpicturesbypage")
    public Result AllPictures(int page,int pageSize,String username,String token) {
        PageHelper.startPage(page, pageSize);
        List<Pictures> picturesList = picturesService.showAllPictures(token, username);
        if (picturesList != null) {
            PageInfo pageInfo = new PageInfo(picturesList);
            if (page > pageInfo.getPages()) {
                return ResultUtil.fail("没有更多的数据了！");
            }
            logger.info("--------show page" + page);
            return ResultUtil.SuccessWithdatas(picturesList);
        } else {
            return ResultUtil.Loginfail("fail");
        }
    }
        //下载接口
        @RequestMapping("/download")
        public Result Download(int id,String username,String token)
        {
            String url=picturesService.searchUrl(id,token,username);
            if(url!=null)
            {
                logger.info("download picture id="+id);
                return ResultUtil.SuccessWithdata(url);
            }
            else
            {
                return ResultUtil.Loginfail("fail");
            }
        }
        @RequestMapping("/adddianzan")
        public Result AddDianzan(int id,String username,String token)
        {
           int count =picturesService.addLiked(id,username,token);
           if(count!=-1&&count!=-2)
            {
                logger.info("pid ="+id+" Liked update!");
                return ResultUtil.SuccessWithdata(count);
            }
            else if(count==-2)
            {
                return  ResultUtil.Loginfail("failed");
            }
            else
            {
               return ResultUtil.fail("failed");
            }
    }
        @RequestMapping("/subdianzan")
        public Result SubDianzan(int id,String username,String token)
        {
            int count =picturesService.subLiked(id,username,token);
            if(count!=-1&&count!=-2)
            {
                logger.info("pid ="+id+" Liked update!");
                return ResultUtil.SuccessWithdata(count);
            }
            else if(count==-2)
            {
                return  ResultUtil.Loginfail("failed");
            }
            else
            {
                return ResultUtil.fail("failed");
            }
        }
}

