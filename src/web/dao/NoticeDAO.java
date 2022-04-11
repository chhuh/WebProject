package web.dao;

import java.util.*;
import java.sql.*;
import javax.sql.*;

import web.vo.NoticeVO;

import javax.naming.*;

public interface NoticeDAO {
	public ArrayList<NoticeVO> getNoticeList();
}
