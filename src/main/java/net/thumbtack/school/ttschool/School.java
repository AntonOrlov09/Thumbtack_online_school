package net.thumbtack.school.ttschool;

import java.util.*;

public class School {
    private String name;
    private int year;
    private final Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if ((name == null) || (name.equals(""))) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group gr : groups) {
            if (gr.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
        groups.remove(group);
    }

    public void removeGroup(String name) throws TrainingException {
        if (!(groups.removeIf(group -> group.getName().equals(name)))) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return getYear() == school.getYear() &&
                getName().equals(school.getName()) &&
                getGroups().equals(school.getGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYear(), getGroups());
    }
}
