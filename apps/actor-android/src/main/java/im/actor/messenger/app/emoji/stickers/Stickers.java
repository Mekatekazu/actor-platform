package im.actor.messenger.app.emoji.stickers;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import im.actor.messenger.R;
import im.actor.messenger.app.AppContext;
import im.actor.messenger.app.util.io.IOUtils;

import static im.actor.messenger.app.Core.core;

/**
 * Created by Jesus Christ. Amen.
 */
public class Stickers {
    public final static StickersPack animalPack = new StickersPack("0", "2", new String[]{
            "2",    // panda
            "1",    // doge
            "3",    // bear
            "4",    // koala
            "5",    // grumpy
            "6",    // dove
            "0",    // chicken
            "7",    // monkey
            "8",    // elephant
            "9",    // rat
            "10",   // frog
            "11",   // pig
            "12"    // goat

    });
    private static StickersPack stewiePack = new StickersPack("1", "ass", new String[]{
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
            "ass",
    });

    public final static StickersPack[] getPacks(){
        return new StickersPack[]{ animalPack, stewiePack };
    }

    public static String getFile(String packId, String stickerId) {
        Context context = AppContext.getContext();
        File sourceFile = context.getFileStreamPath("sticker_" + stickerId + ".png");
        try {
            InputStream fileIS = AppContext.getContext().getAssets().open("stickers_pack_" + packId + "/sticker_" + stickerId + ".png");
            IOUtils.copy(fileIS, sourceFile);
            fileIS.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceFile.getAbsolutePath();
    }
}
