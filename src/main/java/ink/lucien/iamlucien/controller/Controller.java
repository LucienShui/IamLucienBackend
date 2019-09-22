package ink.lucien.iamlucien.controller;

import ink.lucien.iamlucien.dto.ResultDTO;

import ink.lucien.iamlucien.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v0.0.1")
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
}
