package bean;

import java.io.Serializable;
import lombok.Data;

/**
 * movie
 * @author 
 */
@Data
public class Movie implements Serializable {
    private Integer id;

    private String title;

    private String score;

    private String titleSub;

    private String story;

    private String classid;

    private String releasetime;

    private String duration;

    private String regionid;

    private String langid;

    private String custompicpos;

    private static final long serialVersionUID = 1L;
}