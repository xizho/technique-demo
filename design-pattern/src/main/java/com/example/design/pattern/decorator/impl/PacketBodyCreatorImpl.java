package com.example.design.pattern.decorator.impl;

import com.example.design.pattern.decorator.IPacketCreator;

/**
 * 类职责：<br/>
 *
 * <p>Title: PacketBodyCreatorImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 10:45
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class PacketBodyCreatorImpl implements IPacketCreator {

    @Override
    public String handleContent() {
        return "Content of Packet .";
    }
}
