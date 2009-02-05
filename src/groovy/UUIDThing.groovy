import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;
/**
 *
 * @author a03182
 */
class UUIDThing {
	def main() {
        UUID thing = UUIDGenerator.getInstance().generateRandomUUID();
    }
}

