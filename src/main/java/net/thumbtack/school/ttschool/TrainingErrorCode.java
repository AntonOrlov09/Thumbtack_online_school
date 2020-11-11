package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_LASTNAME("Trainee wrong lastName"),
    TRAINEE_WRONG_FIRSTNAME("Trainee wrong firstName"),
    TRAINEE_WRONG_RATING("Trainee wrong rating"),
    GROUP_WRONG_NAME("Group wrong name"),
    SCHOOL_WRONG_NAME("School wrong name"),
    GROUP_WRONG_ROOM("Group wrong room"),
    TRAINEE_NOT_FOUND("Trainee not found"),
    GROUP_NOT_FOUND("Group not found"),
    DUPLICATE_GROUP_NAME("Duplicate group name"),
    DUPLICATE_TRAINEE("Duplicate trainee"),
    EMPTY_TRAINEE_QUEUE("Empty trainee queue");


    private final String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
