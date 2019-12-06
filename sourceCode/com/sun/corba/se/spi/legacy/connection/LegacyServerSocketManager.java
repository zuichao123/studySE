/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.corba.se.spi.legacy.connection;

import com.sun.corba.se.spi.legacy.connection.LegacyServerSocketEndPointInfo;

/**
 * @author Harold Carr
 */
public interface LegacyServerSocketManager
{
    public int legacyGetTransientServerPort(String type);
    public int legacyGetPersistentServerPort(String socketType);
    public int legacyGetTransientOrPersistentServerPort(String socketType);

    public LegacyServerSocketEndPointInfo legacyGetEndpoint(String name);

    public boolean legacyIsLocalServerPort(int port);
}

// End of file.
