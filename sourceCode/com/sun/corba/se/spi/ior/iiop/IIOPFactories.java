/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.ior.iiop ;

import com.sun.corba.se.impl.ior.iiop.*;
import com.sun.corba.se.impl.orbutil.ORBConstants;
import com.sun.corba.se.spi.ior.*;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.ior.iiop.IIOPAddress;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate;
import com.sun.corba.se.spi.orb.ORB;
import org.omg.CORBA_2_3.portable.InputStream;
import org.omg.IOP.*;

/** This class provides all of the factories for the IIOP profiles and
 * components.  This includes direct construction of profiles and templates,
 * as well as constructing factories that can be registered with an
 * IdentifiableFactoryFinder.
 */
public abstract class IIOPFactories {
    private IIOPFactories() {}

    public static IdentifiableFactory makeRequestPartitioningComponentFactory()
    {
        return new EncapsulationFactoryBase(ORBConstants.TAG_REQUEST_PARTITIONING_ID) {
            public Identifiable readContents(InputStream in)
            {
                int threadPoolToUse = in.read_ulong();
                Identifiable comp =
                    new RequestPartitioningComponentImpl(threadPoolToUse);
                return comp;
            }
        };
    }

    public static RequestPartitioningComponent makeRequestPartitioningComponent(
            int threadPoolToUse)
    {
        return new RequestPartitioningComponentImpl(threadPoolToUse);
    }

    public static IdentifiableFactory makeAlternateIIOPAddressComponentFactory()
    {
        return new EncapsulationFactoryBase(TAG_ALTERNATE_IIOP_ADDRESS.value) {
            public Identifiable readContents( InputStream in )
            {
                IIOPAddress addr = new IIOPAddressImpl( in ) ;
                Identifiable comp =
                    new AlternateIIOPAddressComponentImpl( addr ) ;
                return comp ;
            }
        } ;
    }

    public static AlternateIIOPAddressComponent makeAlternateIIOPAddressComponent(
        IIOPAddress addr )
    {
        return new AlternateIIOPAddressComponentImpl( addr ) ;
    }

    public static IdentifiableFactory makeCodeSetsComponentFactory()
    {
        return new EncapsulationFactoryBase(TAG_CODE_SETS.value) {
            public Identifiable readContents( InputStream in )
            {
                return new CodeSetsComponentImpl( in ) ;
            }
        } ;
    }

    public static CodeSetsComponent makeCodeSetsComponent( ORB orb )
    {
        return new CodeSetsComponentImpl( orb ) ;
    }

    public static IdentifiableFactory makeJavaCodebaseComponentFactory()
    {
        return new EncapsulationFactoryBase(TAG_JAVA_CODEBASE.value) {
            public Identifiable readContents( InputStream in )
            {
                String url = in.read_string() ;
                Identifiable comp = new JavaCodebaseComponentImpl( url ) ;
                return comp ;
            }
        } ;
    }

    public static JavaCodebaseComponent makeJavaCodebaseComponent(
        String codebase )
    {
        return new JavaCodebaseComponentImpl( codebase ) ;
    }

    public static IdentifiableFactory makeORBTypeComponentFactory()
    {
        return new EncapsulationFactoryBase(TAG_ORB_TYPE.value) {
            public Identifiable readContents( InputStream in )
            {
                int type = in.read_ulong() ;
                Identifiable comp = new ORBTypeComponentImpl( type ) ;
                return comp ;
            }
        } ;
    }

    public static ORBTypeComponent makeORBTypeComponent( int type )
    {
        return new ORBTypeComponentImpl( type ) ;
    }

    public static IdentifiableFactory makeMaxStreamFormatVersionComponentFactory()
    {
        return new EncapsulationFactoryBase(TAG_RMI_CUSTOM_MAX_STREAM_FORMAT.value) {
            public Identifiable readContents(InputStream in)
            {
                byte version = in.read_octet() ;
                Identifiable comp = new MaxStreamFormatVersionComponentImpl(version);
                return comp ;
            }
        };
    }

    public static MaxStreamFormatVersionComponent makeMaxStreamFormatVersionComponent()
    {
        return new MaxStreamFormatVersionComponentImpl() ;
    }

    public static IdentifiableFactory makeJavaSerializationComponentFactory() {
        return new EncapsulationFactoryBase(
                                ORBConstants.TAG_JAVA_SERIALIZATION_ID) {
            public Identifiable readContents(InputStream in) {
                byte version = in.read_octet();
                Identifiable cmp = new JavaSerializationComponent(version);
                return cmp;
            }
        };
    }

    public static JavaSerializationComponent makeJavaSerializationComponent() {
        return JavaSerializationComponent.singleton();
    }

    public static IdentifiableFactory makeIIOPProfileFactory()
    {
        return new EncapsulationFactoryBase(TAG_INTERNET_IOP.value) {
            public Identifiable readContents( InputStream in )
            {
                Identifiable result = new IIOPProfileImpl( in ) ;
                return result ;
            }
        } ;
    }

    public static IIOPProfile makeIIOPProfile( ORB orb, ObjectKeyTemplate oktemp,
        ObjectId oid, IIOPProfileTemplate ptemp )
    {
        return new IIOPProfileImpl( orb, oktemp, oid, ptemp ) ;
    }

    public static IIOPProfile makeIIOPProfile( ORB orb,
        org.omg.IOP.TaggedProfile profile )
    {
        return new IIOPProfileImpl( orb, profile ) ;
    }

    public static IdentifiableFactory makeIIOPProfileTemplateFactory()
    {
        return new EncapsulationFactoryBase(TAG_INTERNET_IOP.value) {
            public Identifiable readContents( InputStream in )
            {
                Identifiable result = new IIOPProfileTemplateImpl( in ) ;
                return result ;
            }
        } ;
    }

    public static IIOPProfileTemplate makeIIOPProfileTemplate( ORB orb,
        GIOPVersion version, IIOPAddress primary )
    {
        return new IIOPProfileTemplateImpl( orb, version, primary ) ;
    }

    public static IIOPAddress makeIIOPAddress( ORB orb, String host, int port )
    {
        return new IIOPAddressImpl( orb, host, port ) ;
    }

    public static IIOPAddress makeIIOPAddress( InputStream is )
    {
        return new IIOPAddressImpl( is ) ;
    }
}
