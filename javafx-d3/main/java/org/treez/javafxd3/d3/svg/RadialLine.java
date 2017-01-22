package org.treez.javafxd3.d3.svg;

import org.treez.javafxd3.d3.functions.DataFunction;

import org.treez.javafxd3.d3.core.JsEngine;
import org.treez.javafxd3.d3.core.JsObject;

/**
 * A line generator where each points may be expressed as radial coordinates.
 * <p>
 * 
 * 
 * 
 */
public class RadialLine extends Line {

	//#region CONSTRUCTORS

	/**
	 * Constructor
	 * 
	 * @param engine
	 * @param wrappedJsObject
	 */
	public RadialLine(JsEngine engine, JsObject wrappedJsObject) {
		super(engine, wrappedJsObject);
	}

	//#end region

	//#region METHODS

	/**
	 * Set the radius coordinates of points generated by this generator.
	 * 
	 * @param d
	 *            the radius
	 * @return the current line
	 */
	public RadialLine radius(double d) {
		JsObject result = call("radius", d);
		return new RadialLine(engine, result);
	}

	/**
	 * Set the function used to compute radius coordinates of points generated
	 * by this line generator. The function is invoked for each element in the
	 * data array passed to the line generator.
	 * <p>
	 * The default accessor assumes that each input element is a two-element
	 * array of numbers.
	 * 
	 * @param datumFunction
	 * @return the current line
	 */
	public RadialLine radius(final DataFunction<Double> callback) {

		assertObjectIsNotAnonymous(callback);

		String callbackName = createNewTemporaryInstanceName();
		JsObject d3JsObject = getD3();
		d3JsObject.setMember(callbackName, callback);

		String command = "this.radius(function(d, i) { " //
				+ "return d3." + callbackName + ".apply(this,{datum:d},i);" //
				+ " });";
		JsObject result = evalForJsObject(command);
		return new RadialLine(engine, result);

	}

	/**
	 * Set the angle coordinates of points generated by this generator.
	 * 
	 * @param d
	 *            the angle
	 * @return the current line
	 */
	public RadialLine angle(double d) {
		JsObject result = call("angle", d);
		return new RadialLine(engine, result);
	}

	/**
	 * Set the function used to compute angle coordinates of points generated by
	 * this line generator. The function is invoked for each element in the data
	 * array passed to the line generator.
	 * <p>
	 * The default accessor assumes that each input element is a two-element
	 * array of numbers.
	 * 
	 * @param datumFunction
	 * @return the current line
	 */
	public RadialLine angle(final DataFunction<Double> callback) {

		assertObjectIsNotAnonymous(callback);

		String callbackName = createNewTemporaryInstanceName();
		JsObject d3JsObject = getD3();
		d3JsObject.setMember(callbackName, callback);

		String command = "this.angle(function(d, i) { " //
				+ "return d3." + callbackName + ".apply(this,{datum:d},i);" //
				+ " });";
		JsObject result = evalForJsObject(command);
		return new RadialLine(engine, result);
	}

}
