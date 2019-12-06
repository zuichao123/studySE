/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.protocol;

import com.sun.corba.se.impl.logging.POASystemException;
import com.sun.corba.se.impl.protocol.LocalClientRequestDispatcherBase;
import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import com.sun.corba.se.spi.oa.OADestroyed;
import com.sun.corba.se.spi.oa.OAInvocationInfo;
import com.sun.corba.se.spi.oa.ObjectAdapter;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.protocol.ForwardException;

// XXX This should be in the SPI

public abstract class ServantCacheLocalCRDBase extends LocalClientRequestDispatcherBase
{

    private OAInvocationInfo cachedInfo ;
    protected POASystemException wrapper ;

    protected ServantCacheLocalCRDBase( ORB orb, int scid, IOR ior )
    {
        super( orb, scid, ior ) ;
        wrapper = POASystemException.get( orb,
            CORBALogDomains.RPC_PROTOCOL ) ;
    }

    protected synchronized OAInvocationInfo getCachedInfo()
    {
        if (!servantIsLocal)
            throw wrapper.servantMustBeLocal() ;

        if (cachedInfo == null) {
            ObjectAdapter oa = oaf.find( oaid ) ;
            cachedInfo = oa.makeInvocationInfo( objectId ) ;

            // InvocationInfo must be pushed before calling getInvocationServant
            orb.pushInvocationInfo( cachedInfo ) ;

            try {
                oa.enter( );
                oa.getInvocationServant( cachedInfo ) ;
            } catch (ForwardException freq) {
                throw wrapper.illegalForwardRequest( freq ) ;
            } catch( OADestroyed oades ) {
                // This is an error since no user of this implementation
                // should ever throw this exception
                throw wrapper.adapterDestroyed( oades ) ;
            } finally {
                oa.returnServant( );
                oa.exit( );
                orb.popInvocationInfo() ;
            }
        }

        return cachedInfo ;
    }
}

// End of File
