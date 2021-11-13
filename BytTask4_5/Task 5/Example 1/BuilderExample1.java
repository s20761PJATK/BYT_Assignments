import java.security.acl.Group;

//Example of Builder Method Pattern (First)
public class BuilderExample1 implements  UniBuilder{
    Class cls;
    TutorialGroup tutorialGroup;
    Teacher teacher;

    public BuilderExample1(Class cls, TutorialGroup tutorialGroup, Teacher teacher)
    {
        this.cls = cls;
        this.tutorialGroup = tutorialGroup;
        this.teacher = teacher;
    }


    @Override
    public void setClass(Class cls) {
        this.cls = cls;
    }

    @Override
    public void setTutorialGroup(TutorialGroup tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    @Override
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
////////////////
class Class
{
    private String className;
    private String classType;
    private boolean IsOnline;

    public Class(String className, String classType)
    {
        this.className = className;
        this.classType = classType;
    }
    public void SetOfflineClass()
    {
        this.IsOnline = false;
    }
    public void SetOnlineClass()
    {
        this.IsOnline = true;
    }

    public String getClassName() {
        return className;
    }
    public String getClassType() {
        return classType;
    }
    public boolean isOnline() {
        return IsOnline;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }
    public void setOnline(boolean online) {
        IsOnline = online;
    }
}
////////////////
class TutorialGroup
{
    private int GroupNumber;
    private String GroupName;
    private int GroupStudentAmt;

    public TutorialGroup(int GroupNumber, String GroupName)
    {
        this.GroupNumber = GroupNumber;
        this.GroupName = GroupName;
    }
    public void AddStudent()
    {
        this.GroupStudentAmt++;
    }
    public void RemoveStudent()
    {
        this.GroupStudentAmt--;
    }

    public int getGroupNumber() {
        return GroupNumber;
    }
    public String getGroupName() {
        return GroupName;
    }
    public int getGroupStudentAmt() {
        return GroupStudentAmt;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }
    public void setGroupNumber(int groupNumber) {
        GroupNumber = groupNumber;
    }
    public void setGroupStudentAmt(int groupStudentAmt) {
        GroupStudentAmt = groupStudentAmt;
    }
}
////////////
class Teacher
{
    private int TeacherID;
    private String TeacherName;
    private String TeacherSurname;
    private String TeacherCredentials;

    public Teacher(int TeacherID, String TeacherName, String TeacherSurname, String TeacherCredentials)
    {
        this.TeacherID = TeacherID;
        this.TeacherName = TeacherName;
        this.TeacherSurname = TeacherSurname;
        this.TeacherCredentials = TeacherCredentials;
    }

    public int getTeacherID() {
        return TeacherID;
    }
    public String getTeacherCredentials() {
        return TeacherCredentials;
    }
    public String getTeacherName() {
        return TeacherName;
    }
    public String getTeacherSurname() {
        return TeacherSurname;
    }

    public void setTeacherCredentials(String teacherCredentials) {
        TeacherCredentials = teacherCredentials;
    }
    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }
    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
    public void setTeacherSurname(String teacherSurname) {
        TeacherSurname = teacherSurname;
    }
}
