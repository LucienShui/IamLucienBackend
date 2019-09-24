package ink.lucien.iamlucien.controller;

import ink.lucien.iamlucien.dto.ResultDTO;

import ink.lucien.iamlucien.mapper.FriendMapper;
import ink.lucien.iamlucien.model.FriendPO;

import ink.lucien.iamlucien.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v0.0.1")
@Slf4j
public class Controller {

    private final FriendMapper friendMapper;

    public Controller(FriendMapper friendMapper) {
        this.friendMapper = friendMapper;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultDTO<String> index() {
        ResultDTO<String> result = new ResultDTO<>();

        result.setData("Hello World!");
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultDTO<List<FriendPO>> getAll() {
        ResultDTO<List<FriendPO>> result = new ResultDTO<>();

        try {
            List<FriendPO> queryResult = friendMapper.selectAll();
            result.setCode(200);
            result.setMessage("success");
            result.setData(queryResult.stream().filter(
                    item -> item.getType().equals(FriendPO.TYPE.GLOBAL)
            ).collect(Collectors.toList()));
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("error");
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/grep", method = RequestMethod.POST)
    public ResultDTO<List<FriendPO>> test(@RequestParam("value") String name) {
        log.trace("{} value = {}", Util.getLineNumber(), name);
        ResultDTO<List<FriendPO>> result = new ResultDTO<>();

        try {
            List<FriendPO> queryResult = friendMapper.selectLike(name);
            result.setCode(200);
            result.setMessage("success");
            result.setData(queryResult);
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("error");
            e.printStackTrace();
        }

        return result;
    }
}
