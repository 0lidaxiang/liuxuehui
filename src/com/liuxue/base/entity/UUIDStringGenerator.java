package com.liuxue.base.entity;

import org.apache.commons.codec.binary.Hex;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.AbstractUUIDGenerator;
import org.hibernate.id.Configurable;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.type.Type;
import org.hibernate.util.BytesHelper;
import org.hibernate.util.PropertiesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UUIDStringGenerator extends AbstractUUIDGenerator implements Configurable {
	private static final Logger log = LoggerFactory.getLogger( UUIDStringGenerator.class );
	private static boolean warned = false;

	private String sep = "";

	public UUIDStringGenerator() {
		if ( ! warned ) {
			warned = true;
			log.warn(
					"Using {} which does not generate IETF RFC 4122 compliant UUID values; consider using {} instead",
					this.getClass().getName(),
					UUIDGenerator.class.getName()
			);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void configure(Type type, Properties params, Dialect d) {
		sep = PropertiesHelper.getString( "separator", params, "" );
	}

	/**
	 * {@inheritDoc}
	 */
	public Serializable generate(SessionImplementor session, Object obj) {
		return new StringBuffer( 14 )
				.append("00")//.append( sep )
				.append( format( getJVM() ) )//.append( sep )
				//.append( format( getHiTime() ) ).append( sep )
				//.append( format( getLoTime() ) ).append( sep )
				.append( format( getCount() ) )
				.toString();
	}
	
	protected String format(int intValue) {
		return new String(Hex.encodeHex(BytesHelper.fromInt(intValue))) ;
	}

	protected String format(short shortValue) {
		return new String(Hex.encodeHex( BytesHelper.fromShort(shortValue))) ;
	}
	
	public static void main(String[] args) {
		UUIDStringGenerator id = new UUIDStringGenerator();
		for(int i=0;i<10;i++) {
			String s = (String) id.generate(null, null);
			System.out.println(s+":"+s.length());
		}
	}
}
