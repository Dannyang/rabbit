package com.example.rabbit.mapper;

import com.example.rabbit.entity.Invite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;

@Mapper
public interface InviteMapper {
    Cursor<Invite> getAllInvites();
}
