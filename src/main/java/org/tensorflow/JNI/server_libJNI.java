/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.tensorflow.JNI;

public class server_libJNI {
  public final static native void PyServer_New(long jarg1, long jarg3);
  public final static native void PyServer_Start(long jarg1, long jarg2);
  public final static native void PyServer_Stop(long jarg1, long jarg2);
  public final static native void PyServer_Join(long jarg1, long jarg2);
  public final static native void tensorflow_set(long jarg1);
  public final static native long tensorflow_get();
}
