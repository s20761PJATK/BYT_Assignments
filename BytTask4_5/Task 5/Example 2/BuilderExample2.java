
//Example of Builder Method Pattern (Second)
public class BuilderExample2 implements StoryBuilder{
    Protagonist protagonist;
    Villain villain;
    World world;
    Problem problem;

    public BuilderExample2(Protagonist protagonist, Villain villain, World world, Problem problem)
    {
        this.protagonist = protagonist;
        this.villain = villain;
        this.world = world;
        this.problem = problem;
    }

    @Override
    public void setProtagonist() {
        this.protagonist = protagonist;
    }

    @Override
    public void SetVillain() {
        this.villain = villain;
    }

    @Override
    public void setWorld() {
        this.world = world;
    }

    @Override
    public void SetProblem() {
        this.problem = problem;
    }
}

////////////
class Protagonist
{
    private String name;
    private String familyName;
    private int age;
    private Backstory backstory;

    public Protagonist(String name, String familyName, int age)
    {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }

    public Backstory getBackstory() {
        return backstory;
    }
    public int getAge() {
        return age;
    }
    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBackstory(Backstory backstory) {
        this.backstory = backstory;
    }
}

//////////
class Villain
{
    private String Nickname;
    private Backstory backstory;
    private String[] evildeeds;

    public Backstory getBackstory() {
        return backstory;
    }
    public String getNickname() {
        return Nickname;
    }
    public String[] getEvildeeds() {
        return evildeeds;
    }

    public void setEvildeeds(String[] evildeeds) {
        this.evildeeds = evildeeds;
    }
    public void setNickname(String nickname) {
        Nickname = nickname;
    }
    public void setBackstory(Backstory backstory) {
        this.backstory = backstory;
    }
}

///////////
class World
{
    private String worldname;
    private int size; //km^2 of surface
    private int countryamt;

    public int getCountryamt() {
        return countryamt;
    }
    public int getSize() {
        return size;
    }
    public String getWorldname() {
        return worldname;
    }

    public void setCountryamt(int countryamt) {
        this.countryamt = countryamt;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setWorldname(String worldname) {
        this.worldname = worldname;
    }
}

///////////
class Problem
{
    private String problemNickname;
    private String description;
    private int startDate;
    private boolean worldEnding;

    public String getDescription() {
        return description;
    }
    public boolean isWorldEnding() {
        return worldEnding;
    }
    public int getStartDate() {
        return startDate;
    }
    public String getProblemNickname() {
        return problemNickname;
    }

    public void setProblemNickname(String problemNickname) {
        this.problemNickname = problemNickname;
    }
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
    public void setWorldEnding(boolean worldEnding) {
        this.worldEnding = worldEnding;
    }
    public void setDescription(String description) {
    this.description = description;
    }
}

////////////
class Backstory
{
    private String description;
    private BackstoryType backstoryType;

    public BackstoryType getBackstoryType() {
        return backstoryType;
    }
    public String getDescription() {
        return description;
    }

    public void setBackstoryType(BackstoryType backstoryType) {
        this.backstoryType = backstoryType;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}