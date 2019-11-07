package dao;

import db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import bean.Message;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MessageDao {
    //根据查询条件查询消息列表
    public List<Message> queryMessageList(String message, String description){
        DBAccess dbAccess=new DBAccess();
        List<Message>messageList=new ArrayList<Message>();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            //Message message=new Message();
            Message message1=new Message();
            message1.setMessage(message);
            messageList=sqlSession.selectList("se_ai_data.findse_ai",message1);
            System.out.println(messageList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }

        return messageList;
    }
    //单条删除
    public void deleteOne(int id){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            sqlSession.delete("se_ai_data.deleteOne",id);
            sqlSession.commit();//mybatis修改数据库后需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    //多条删除
    public void deleteBatch(List<Integer> ids){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            sqlSession.delete("se_ai_data.deleteBatch",ids);
            sqlSession.commit();//mybatis修改数据库后需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    //添加
    public void insert(Integer id,String message){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            Message messages=new Message();
            messages.setId(id);
            messages.setMessage(message);
            sqlSession.insert("se_ai_data.insert",messages);
            sqlSession.commit();//mybatis修改数据库后需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public void update(Integer id,String message){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            Message messages=new Message();
            messages.setId(id);
            messages.setMessage(message);
            sqlSession.update("se_ai_data.update",messages);
            sqlSession.commit();//mybatis修改数据库后需要手动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }


    public static void main(String[] args){
        BasicConfigurator.configure();
        MessageDao messageDao=new MessageDao();
        //删除
        List<Integer> list=new ArrayList<Integer>();
        list.add(22);
        list.add(Integer.valueOf(23));
        list.add(Integer.valueOf(24));
        //messageDao.deleteBatch(list);
        //添加
        messageDao.insert(32,"我好困");
        //修改
        messageDao.update(20,"你不好世界");
        //查询
        messageDao.queryMessageList("","");
    }

}
