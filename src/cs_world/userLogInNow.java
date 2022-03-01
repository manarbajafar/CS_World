
package cs_world;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class userLogInNow {
    public static String userLogIn="";
    public static int ScoreuserLogIn=0;
    public static int levelDoneNumForuserLogIn=0;
    public static int ChosenCharacter=0;
    public static  int ChosenLvl=0;
    
    public static void increaseUserScore(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Score> sList = null;
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("Score list size: "+sList.size());
        for(Score s: sList)
        {
            if(s.getName().equals(userLogIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                ScoreuserLogIn=s.getScore();
                tx.commit();
                
                session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();
                ScoreuserLogIn +=5;
                s.setScore(ScoreuserLogIn );
                session1.update(s);
                tx1.commit();
                session1.close();
            }
            
                }  
    }
    public static int getLevelDoneNum(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Score> sList = null;
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("Score list size: "+sList.size());
        for(Score s: sList)
        {
            if(s.getName().equals(userLogIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                levelDoneNumForuserLogIn=s.getLevelDoneNum();
                tx.commit();
                session1.close();
            }
        }        
        return levelDoneNumForuserLogIn;
      }
    public static void UpdatelevelDoneNum(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Score> sList = null;
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("Score list size: "+sList.size());
        for(Score s: sList)
        {
            if(s.getName().equals(userLogIn)){
                levelDoneNumForuserLogIn=getLevelDoneNum();
               
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();
                levelDoneNumForuserLogIn ++;
                s.setLevelDoneNum(levelDoneNumForuserLogIn );
                session1.update(s);
                tx1.commit();
                session1.close();
            }
            
                }  
    }
    
    public static int getScore(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Score> sList = null;
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("Score list size: "+sList.size());
        for(Score s: sList)
        {
            if(s.getName().equals(userLogIn)){
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session1.beginTransaction();
                ScoreuserLogIn=s.getScore();
                tx.commit();
                session1.close();
            }
        }        
        return ScoreuserLogIn;
      }
}
