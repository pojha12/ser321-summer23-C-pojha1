package example.grpcClient;

import service.*;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

public class ZooImpl extends ZooGrpc.ZooImplBase {
    private List<Animal> animals;

    public ZooImpl() {
        animals = new ArrayList<>();
    }

    @Override
    public void add(AddAnimalRequest request, StreamObserver<AddAnimalResponse> responseObserver) {
        Animal newAnimal = request.getAnimal();
        animals.add(newAnimal);

        AddAnimalResponse response = AddAnimalResponse.newBuilder()
                .setIsSuccess(true)
                .setMessage("Animal added to the zoo")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void speak(SpeakRequest request, StreamObserver<SpeakResponse> responseObserver) {
        String animalName = request.getName();
        List<String> speakingAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                speakingAnimals.add(animal.getAnimalSound());
            }
        }

        if (!speakingAnimals.isEmpty()) {
            SpeakResponse response = SpeakResponse.newBuilder()
                    .setIsSuccess(true)
                    .addAllAnimals(speakingAnimals)
                    .build();

            responseObserver.onNext(response);
        } else {
            SpeakResponse response = SpeakResponse.newBuilder()
                    .setIsSuccess(false)
                    .setError("No animals found with the given name")
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

    @Override
    public void speakAll(Empty request, StreamObserver<SpeakResponse> responseObserver) {
        List<String> speakingAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            speakingAnimals.add(animal.getAnimalSound());
        }

        if (!speakingAnimals.isEmpty()) {
            SpeakResponse response = SpeakResponse.newBuilder()
                    .setIsSuccess(true)
                    .addAllAnimals(speakingAnimals)
                    .build();

            responseObserver.onNext(response);
        } else {
            SpeakResponse response = SpeakResponse.newBuilder()
                    .setIsSuccess(false)
                    .setError("No animals found in the zoo")
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
