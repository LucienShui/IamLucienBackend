package ink.lucien.iamlucien.mapper;

import ink.lucien.iamlucien.model.FriendPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Lucien on 2019/09/22
 */
@Mapper
public interface FriendMapper {
    // TODO

    List<FriendPO> selectAll();

    List<FriendPO> selectLike(@Param("name") String name);
}
