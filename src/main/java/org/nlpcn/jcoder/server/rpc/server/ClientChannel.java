package org.nlpcn.jcoder.server.rpc.server;

import java.beans.Transient;
import java.util.Set;

import com.google.common.collect.Sets;

import io.netty.channel.Channel;

/**
 * package mobile channel
 * 
 * @author Ansj
 *
 */
public class ClientChannel {

	private String clientId;

	private Set<Channel> channels;

	private long loginTime;

	public ClientChannel(String clientId,Channel channel) {
		this.clientId = clientId ;
		this.channels = Sets.newHashSet(channel);
		this.loginTime = System.currentTimeMillis();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void addChannel(Channel channel) {
		channels.add(channel) ;
	}

	@Transient
	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

}
