package me.Chilybones.Sprinting;


import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.kvq.plugin.trails.API.SuperTrailsAPI;

public class SprintEvent implements Listener {
	
	@EventHandler (priority = EventPriority.LOWEST)
	public void onPlayerSprint(PlayerToggleSprintEvent event) {
		if (event.getPlayer().hasPermission("speedster.run")) {
			float speed = event.getPlayer().getWalkSpeed();
			
			if (!event.getPlayer().isSprinting()) {
				event.getPlayer().setWalkSpeed(speed * 4);
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 800, 7));
				event.getPlayer().spawnParticle(Particle.LAVA, event.getPlayer().getLocation(), 100);
				event.getPlayer().spawnParticle(Particle.EXPLOSION_NORMAL, event.getPlayer().getLocation(), 100);
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_LIGHTNING_IMPACT, 5, 0);
				SuperTrailsAPI.setTrail(26, event.getPlayer());
				//event.getPlayer().getWorld().strikeLightningEffect(event.getPlayer().getLocation()); -- Lightning Strike
			}
			
			if (event.getPlayer().isSprinting()) {
				event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
				event.getPlayer().setWalkSpeed(speed/4);
				SuperTrailsAPI.setTrail(0, event.getPlayer());
				//event.getPlayer().spawnParticle(Particle.FLAME, event.getPlayer().getLocation(), 100); -- Flames
				//event.getPlayer().getWorld().strikeLightningEffect(event.getPlayer().getLocation()); -- Lightning Strike
			}
		}
	}

}


/**
 * 
 * 
 * 
 *       Made by Chilybones
 * 
 * 
 * 
 */