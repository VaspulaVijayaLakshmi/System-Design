import enums.Direction;

public class ExternalRequest {

    int floorNumber;
    Direction direction;

    public ExternalRequest(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }
}
