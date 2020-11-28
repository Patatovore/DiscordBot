package fr.Patatovore.DiscordBot.events;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import fr.Patatovore.DiscordBot.Variables;
import fr.Patatovore.DiscordBot.music.AudioPlayerSendHandler;
import fr.Patatovore.DiscordBot.music.TrackScheduler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class onMessageReceived extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        User u = e.getAuthor();
        Member member = e.getMember();
        if(u.isBot()) return;


        Message message = e.getMessage();
        String content = message.getContentRaw();

        if(!content.startsWith(Variables.prefix)) return;

        String msg = content.substring(1);
        MessageChannel chan = e.getChannel();
        Guild g = e.getGuild();

        if(msg.equals("ping")) {
            chan.sendMessage("Pong!").queue();
        } else if(msg.equals("help")) {
            // Create the EmbedBuilder instance
            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("Liste des commandes", null);

            eb.setColor(new Color(0, 0, 255));

            eb.setDescription("Prefix: !");

            StringBuilder commands = new StringBuilder();
            Enumeration<String> stringEnumeration = Collections.enumeration(Variables.MusicCommands);

            while(stringEnumeration.hasMoreElements()) {
                commands.append(stringEnumeration.nextElement() + "\n");
            }
            eb.addField("Musique:", commands.toString(), false);

            eb.addBlankField(false);

            eb.setAuthor("AmplifiaBot made by Patatovore", null, "https://cdn.discordapp.com/avatars/574288532626210817/5c8c7e6dcf9a3f62151a31034e3680e5.png");

            eb.setFooter("- Amplifia Bot, 2020.", "https://cdn.discordapp.com/avatars/744311136492454048/3101ce2646b44265635c60f9826d1f01.png");

            chan.sendMessage(eb.build()).queue();
        } else if(msg.equals("setstatus")) {
            if(member.hasPermission(Permission.ADMINISTRATOR)) {
                String[] command = e.getMessage().getContentDisplay().split(" ", 2);
                chan.sendMessage(command[1]).queue();
            }
            //TODO
        }
    }
}
