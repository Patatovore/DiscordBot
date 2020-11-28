package fr.Patatovore.DiscordBot;

import fr.Patatovore.DiscordBot.events.onMessageReceived;
import fr.Patatovore.DiscordBot.music.PlayerControl;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault("NzY3MzM1MDc5MzM2NzM4ODM2.X4waew.-zZ70s9Gko3fTx-1iZGwo0I-VPA").build();

        bot.addEventListener(new onMessageReceived());
        bot.addEventListener(new PlayerControl());

        updateCommansd();
    }

    public static void updateCommansd() {
        Variables.MusicCommands.add("- !join <salon> : rejoins le salon spécifié");
        Variables.MusicCommands.add("- !leave : faire quitter le bot de son salon");
        Variables.MusicCommands.add("- !play <Lien youtube> : joue l'audio de la vidéo youtube spécifiée");
        Variables.MusicCommands.add("- !skip : Passe la musique en cours");
        Variables.MusicCommands.add("- !pause: Mets en pause/Relance la lecture");
        Variables.MusicCommands.add("- !stop : Arrête la musique et vide la playlist");
        Variables.MusicCommands.add("- !volume <volume> : Ajuste le volume du bot");
        Variables.MusicCommands.add("- !restart : Relance la musique");
        Variables.MusicCommands.add("- !repeat : Répète la playlist");
        Variables.MusicCommands.add("- !reset - Réinistialise la playlist");
        Variables.MusicCommands.add("- !nowplaying - Envoie le titre de la musique actuellement jouée");
        Variables.MusicCommands.add("- !list - Envoie le contenu de la playlist");
    }
}
