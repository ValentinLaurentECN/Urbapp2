package fr.turfu.urbapp2.DB;

public class Project {

    private static final String TAG = "projet";

    /**************************
     * Attributes
     ***************************/

    /**
     * long project id attributes
     */
    private long project_id;
    /**
     * String project name attributes
     */
    private String project_name;

    /**
     * String project description
     */
    private String project_description;

    /**
     * Date project version
     */
    private int project_version;

    /**
     * Boolean to tell if the project is currently opened by a user or not
     */
    private boolean project_isavailable;

    /**
     * long id of the gpsgeom that locates to the project
     */
    private long gpsGeom_id;

    /*******************
     * CONSTRUCTORS
     *******************/

    public Project() {

    }

    public Project(String n, String d, long gps) {
        this.project_name = n;
        this.project_description = d;
        this.gpsGeom_id = gps;
        this.project_version = 0;
        this.project_isavailable = false;
    }


    /*******************
     * GETTERS
     *******************/


    /**
     * getter for gpsgeom id
     *
     * @return the id of the gpsgeom
     */
    public long getGpsGeom_id() {
        return gpsGeom_id;
    }

    /**
     * getter for the project id
     *
     * @return the id of the project
     */
    public long getProjectId() {
        return project_id;
    }

    /**
     * getter for the name of the project
     *
     * @return the name of the project
     */
    public String getProjectName() {
        return project_name;
    }

    /**
     * getter for the description of the project
     *
     * @return the description of the project
     */
    public String getProjectDescription() {
        return project_description;
    }

    /**
     * get the value of the version
     *
     * @return Int version
     */
    public int getVersion() {
        return project_version;
    }

    /**
     * Get the availability of the project
     *
     * @return Boolean isAvailable
     */
    public boolean getIsAvailable() {
        return project_isavailable;
    }


    /*******************
     * SETTERS
     *******************/


    /**
     * setter for the gpsgeom id
     *
     * @param gpsGeom_id
     */
    public void setGpsGeom_id(long gpsGeom_id) {
        this.gpsGeom_id = gpsGeom_id;
    }

    /**
     * setter for the description of the project
     *
     * @param str
     */
    public void setProjectDescription(String str) {
        this.project_description = str;
    }

    /**
     * setter for the name of the project
     *
     * @param str
     */
    public void setProjectName(String str) {
        this.project_name = str;
    }

    /**
     * setter for the project id
     *
     * @param id
     */
    public void setProjectId(long id) {
        this.project_id = id;
    }

    /**
     * setter for the project version
     *
     * @param v
     */
    public void setProjectVersion(int v) {
        this.project_version = v;
    }

    /**
     * setter for the project availability
     *
     * @param a
     */
    public void setProjectIsavailable(boolean a) {
        this.project_isavailable = a;
    }


    //Override methods
    @Override
    public String toString() {
        return project_name + " " + project_id;
    }


}