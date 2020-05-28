package beans;

import daos.ConnectionDao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 *
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    private String username;
    private String password;    
    private Connection connection; 
    private int selectedItemId;     
    private int menuIndex = 0;

    public SessionBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }    

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

  
    
      
    
    
    
     public void Teacherlogin() throws Exception {
       // FacesContext facesContext = FacesContext.getCurrentInstance();
//        boolean success = true;
        
        try {  
            ConnectionDao connectionDao = new ConnectionDao();
            Connection conn = connectionDao.getConnection();
            String sql = "SELECT u.PASSWORD FROM USER_ROLE ur " +
                "LEFT JOIN USERS u ON ur.USER_ID = u.USER_ID " +
                "LEFT JOIN ROLE r ON ur.ROLE_ID  = r.ROLE_ID " +
                "WHERE r.ROLE_ID  = 2 AND u.USER_NAME_EN = '" + getUsername() + "'";
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                if (getPassword().equals(rs.getString("PASSWORD")))
                      navigate("/first_page");
            }
            
            rs.close();
            ps.close();

//            return list;
        } catch (Exception ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
    
   public void login() throws Exception {
       // FacesContext facesContext = FacesContext.getCurrentInstance();
//        boolean success = true;
        
        try {  
            ConnectionDao connectionDao = new ConnectionDao();
            Connection conn = connectionDao.getConnection();
           String sql = "SELECT u.PASSWORD FROM USER_ROLE ur " +
                "LEFT JOIN USERS u ON ur.USER_ID = u.USER_ID " +
                "LEFT JOIN ROLE r ON ur.ROLE_ID  = r.ROLE_ID " +
                "WHERE r.ROLE_ID  = 1 AND u.USER_NAME_EN = '" + getUsername() + "'";
           
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                if (getPassword().equals(rs.getString("PASSWORD")))
                     navigate("/first_page_Student");
            }
            
            rs.close();
            ps.close();

//            return list;
        } catch (Exception ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    
    
    
   }
      
          public void  back()
      throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;

        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

        }

        if (success) {
            navigate("web Pages/events/manage_events");
        }
   
    }
       public void  UplodeNewLec()
      throws Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;

        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {

        }

        if (success) {
            navigate("/UplodeNewLec");
        }
   
    }

    public void logout() throws Exception {
        try {
            // Release and close database resources and connections 
            if (connection != null) {
                if (!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }

                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            setPassword(null);
            setUsername(null);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
        }
    }

    public void navigate(String url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
        }
    }
}