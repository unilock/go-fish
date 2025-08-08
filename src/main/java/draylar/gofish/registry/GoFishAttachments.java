package draylar.gofish.registry;

import com.mojang.serialization.Codec;
import draylar.gofish.GoFish;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;

@SuppressWarnings("UnstableApiUsage")
public class GoFishAttachments {

    // Used to represent an Entity that is fireproof, i.e. cannot be destroyed by fire or lava.
    public static final AttachmentType<Boolean> FIRE_IMMUNE = AttachmentRegistry.createPersistent(GoFish.id("fire_immune"), Codec.BOOL);

    public static void init() {
        // NO-OP
    }
}
