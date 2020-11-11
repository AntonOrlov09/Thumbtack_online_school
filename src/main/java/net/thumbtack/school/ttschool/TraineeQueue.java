package net.thumbtack.school.ttschool;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    private Queue<Trainee> trainees;

    public TraineeQueue() {
        trainees = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        Trainee traineeRes = trainees.poll();
        if (traineeRes == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return traineeRes;
    }

    public boolean isEmpty() {
        return trainees.isEmpty();
    }

}
