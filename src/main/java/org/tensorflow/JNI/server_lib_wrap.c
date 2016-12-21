/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * This file is not intended to be easily readable and contains a number of
 * coding conventions designed to improve portability and efficiency. Do not make
 * changes to this file unless you know what you are doing--modify the SWIG
 * interface file instead.
 * ----------------------------------------------------------------------------- */


#ifndef SWIGJAVA
#define SWIGJAVA
#endif


/* -----------------------------------------------------------------------------
 *  This section contains generic SWIG labels for method/variable
 *  declarations/attributes, and other compiler dependent labels.
 * ----------------------------------------------------------------------------- */

/* template workaround for compilers that cannot correctly implement the C++ standard */
#ifndef SWIGTEMPLATEDISAMBIGUATOR
# if defined(__SUNPRO_CC) && (__SUNPRO_CC <= 0x560)
#  define SWIGTEMPLATEDISAMBIGUATOR template
# elif defined(__HP_aCC)
/* Needed even with `aCC -AA' when `aCC -V' reports HP ANSI C++ B3910B A.03.55 */
/* If we find a maximum version that requires this, the test would be __HP_aCC <= 35500 for A.03.55 */
#  define SWIGTEMPLATEDISAMBIGUATOR template
# else
#  define SWIGTEMPLATEDISAMBIGUATOR
# endif
#endif

/* inline attribute */
#ifndef SWIGINLINE
# if defined(__cplusplus) || (defined(__GNUC__) && !defined(__STRICT_ANSI__))
#   define SWIGINLINE inline
# else
#   define SWIGINLINE
# endif
#endif

/* attribute recognised by some compilers to avoid 'unused' warnings */
#ifndef SWIGUNUSED
# if defined(__GNUC__)
#   if !(defined(__cplusplus)) || (__GNUC__ > 3 || (__GNUC__ == 3 && __GNUC_MINOR__ >= 4))
#     define SWIGUNUSED __attribute__ ((__unused__))
#   else
#     define SWIGUNUSED
#   endif
# elif defined(__ICC)
#   define SWIGUNUSED __attribute__ ((__unused__))
# else
#   define SWIGUNUSED
# endif
#endif

#ifndef SWIG_MSC_UNSUPPRESS_4505
# if defined(_MSC_VER)
#   pragma warning(disable : 4505) /* unreferenced local function has been removed */
# endif
#endif

#ifndef SWIGUNUSEDPARM
# ifdef __cplusplus
#   define SWIGUNUSEDPARM(p)
# else
#   define SWIGUNUSEDPARM(p) p SWIGUNUSED
# endif
#endif

/* internal SWIG method */
#ifndef SWIGINTERN
# define SWIGINTERN static SWIGUNUSED
#endif

/* internal inline SWIG method */
#ifndef SWIGINTERNINLINE
# define SWIGINTERNINLINE SWIGINTERN SWIGINLINE
#endif

/* exporting methods */
#if (__GNUC__ >= 4) || (__GNUC__ == 3 && __GNUC_MINOR__ >= 4)
#  ifndef GCC_HASCLASSVISIBILITY
#    define GCC_HASCLASSVISIBILITY
#  endif
#endif

#ifndef SWIGEXPORT
# if defined(_WIN32) || defined(__WIN32__) || defined(__CYGWIN__)
#   if defined(STATIC_LINKED)
#     define SWIGEXPORT
#   else
#     define SWIGEXPORT __declspec(dllexport)
#   endif
# else
#   if defined(__GNUC__) && defined(GCC_HASCLASSVISIBILITY)
#     define SWIGEXPORT __attribute__ ((visibility("default")))
#   else
#     define SWIGEXPORT
#   endif
# endif
#endif

/* calling conventions for Windows */
#ifndef SWIGSTDCALL
# if defined(_WIN32) || defined(__WIN32__) || defined(__CYGWIN__)
#   define SWIGSTDCALL __stdcall
# else
#   define SWIGSTDCALL
# endif
#endif

/* Deal with Microsoft's attempt at deprecating C standard runtime functions */
#if !defined(SWIG_NO_CRT_SECURE_NO_DEPRECATE) && defined(_MSC_VER) && !defined(_CRT_SECURE_NO_DEPRECATE)
# define _CRT_SECURE_NO_DEPRECATE
#endif

/* Deal with Microsoft's attempt at deprecating methods in the standard C++ library */
#if !defined(SWIG_NO_SCL_SECURE_NO_DEPRECATE) && defined(_MSC_VER) && !defined(_SCL_SECURE_NO_DEPRECATE)
# define _SCL_SECURE_NO_DEPRECATE
#endif

/* Deal with Apple's deprecated 'AssertMacros.h' from Carbon-framework */
#if defined(__APPLE__) && !defined(__ASSERT_MACROS_DEFINE_VERSIONS_WITHOUT_UNDERSCORES)
# define __ASSERT_MACROS_DEFINE_VERSIONS_WITHOUT_UNDERSCORES 0
#endif

/* Intel's compiler complains if a variable which was never initialised is
 * cast to void, which is a common idiom which we use to indicate that we
 * are aware a variable isn't used.  So we just silence that warning.
 * See: https://github.com/swig/swig/issues/192 for more discussion.
 */
#ifdef __INTEL_COMPILER
# pragma warning disable 592
#endif


/* Fix for jlong on some versions of gcc on Windows */
#if defined(__GNUC__) && !defined(__INTEL_COMPILER)
  typedef long long __int64;
#endif

/* Fix for jlong on 64-bit x86 Solaris */
#if defined(__x86_64)
# ifdef _LP64
#   undef _LP64
# endif
#endif

#include <jni.h>
#include <stdlib.h>
#include <string.h>


/* Support for throwing Java exceptions */
typedef enum {
  SWIG_JavaOutOfMemoryError = 1, 
  SWIG_JavaIOException, 
  SWIG_JavaRuntimeException, 
  SWIG_JavaIndexOutOfBoundsException,
  SWIG_JavaArithmeticException,
  SWIG_JavaIllegalArgumentException,
  SWIG_JavaNullPointerException,
  SWIG_JavaDirectorPureVirtual,
  SWIG_JavaUnknownError
} SWIG_JavaExceptionCodes;

typedef struct {
  SWIG_JavaExceptionCodes code;
  const char *java_exception;
} SWIG_JavaExceptions_t;


static void SWIGUNUSED SWIG_JavaThrowException(JNIEnv *jenv, SWIG_JavaExceptionCodes code, const char *msg) {
  jclass excep;
  static const SWIG_JavaExceptions_t java_exceptions[] = {
    { SWIG_JavaOutOfMemoryError, "java/lang/OutOfMemoryError" },
    { SWIG_JavaIOException, "java/io/IOException" },
    { SWIG_JavaRuntimeException, "java/lang/RuntimeException" },
    { SWIG_JavaIndexOutOfBoundsException, "java/lang/IndexOutOfBoundsException" },
    { SWIG_JavaArithmeticException, "java/lang/ArithmeticException" },
    { SWIG_JavaIllegalArgumentException, "java/lang/IllegalArgumentException" },
    { SWIG_JavaNullPointerException, "java/lang/NullPointerException" },
    { SWIG_JavaDirectorPureVirtual, "java/lang/RuntimeException" },
    { SWIG_JavaUnknownError,  "java/lang/UnknownError" },
    { (SWIG_JavaExceptionCodes)0,  "java/lang/UnknownError" }
  };
  const SWIG_JavaExceptions_t *except_ptr = java_exceptions;

  while (except_ptr->code != code && except_ptr->code)
    except_ptr++;

  (*jenv)->ExceptionClear(jenv);
  excep = (*jenv)->FindClass(jenv, except_ptr->java_exception);
  if (excep)
    (*jenv)->ThrowNew(jenv, excep, msg);
}


/* Contract support */

#define SWIG_contract_assert(nullreturn, expr, msg) if (!(expr)) {SWIG_JavaThrowException(jenv, SWIG_JavaIllegalArgumentException, msg); return nullreturn; } else


  #include <memory>
  #include <vector>
  #include "tensorflow/core/platform/types.h"
  using tensorflow::uint64;
  using tensorflow::string;

  template<class T>
      bool _PyObjAs(PyObject *pystr, T* cstr) {
    T::undefined;  // You need to define specialization _PyObjAs<T>
    return false;
  }

  template<class T>
      PyObject *_PyObjFrom(const T& c) {
    T::undefined;  // You need to define specialization _PyObjFrom<T>
    return NULL;
  }

#ifdef HAS_GLOBAL_STRING
  template<>
      bool _PyObjAs(PyObject *pystr, ::string* cstr) {
    char *buf;
    Py_ssize_t len;
    if (PyBytes_AsStringAndSize(pystr, &buf, &len) == -1) return false;
    if (cstr) cstr->assign(buf, len);
    return true;
  }
#endif
  template<>
      bool _PyObjAs(PyObject *pystr, std::string* cstr) {
    char *buf;
    Py_ssize_t len;
    if (PyBytes_AsStringAndSize(pystr, &buf, &len) == -1) return false;
    if (cstr) cstr->assign(buf, len);
    return true;
  }
#ifdef HAS_GLOBAL_STRING
  template<>
      PyObject* _PyObjFrom(const ::string& c) {
    return PyBytes_FromStringAndSize(c.data(), c.size());
  }
#endif
  template<>
      PyObject* _PyObjFrom(const std::string& c) {
    return PyBytes_FromStringAndSize(c.data(), c.size());
  }

  PyObject* _SwigBytes_FromString(const string& s) {
    return PyBytes_FromStringAndSize(s.data(), s.size());
  }

  // The string must be both ASCII and Unicode compatible, so this routine
  // should be used only for error messages and the like.
  PyObject* _SwigSimpleStr_FromString(const string& s) {
#if PY_MAJOR_VERSION < 3
    return PyString_FromStringAndSize(s.data(), s.size());
#else
    return PyUnicode_FromStringAndSize(s.data(), s.size());
#endif
  }

  template <class T>
  bool tf_vector_input_helper(PyObject * seq, std::vector<T> * out,
                              bool (*convert)(PyObject*, T * const)) {
    PyObject *item, *it = PyObject_GetIter(seq);
    if (!it) return false;
    while ((item = PyIter_Next(it))) {
      T elem;
      bool success = convert(item, &elem);
      Py_DECREF(item);
      if (!success) {
        Py_DECREF(it);
        return false;
      }
      if (out) out->push_back(elem);
    }
    Py_DECREF(it);
    return static_cast<bool>(!PyErr_Occurred());
  }


#include "tensorflow/c/tf_status_helper.h"
#include "tensorflow/core/distributed_runtime/server_lib.h"
#include "tensorflow/core/lib/core/status.h"

using tensorflow::ServerDef;

static void PyServer_New(const ServerDef& server_def,
                         std::unique_ptr<tensorflow::ServerInterface>* out_server,
                         TF_Status* out_status) {
  tensorflow::Status status =
      tensorflow::NewServer(server_def, out_server);
  tensorflow::Set_TF_Status_from_Status(out_status, status);
}

static void PyServer_Start(
    tensorflow::ServerInterface* in_server,
    TF_Status* out_status) {
  tensorflow::Set_TF_Status_from_Status(out_status, in_server->Start());
}

static void PyServer_Stop(
    tensorflow::ServerInterface* in_server,
    TF_Status* out_status) {
  tensorflow::Set_TF_Status_from_Status(out_status, in_server->Stop());
}

static void PyServer_Join(
    tensorflow::ServerInterface* in_server,
    TF_Status* out_status) {
  tensorflow::Set_TF_Status_from_Status(out_status, in_server->Join());
}


#ifdef __cplusplus
extern "C" {
#endif

SWIGEXPORT void JNICALL Java_server_1libJNI_PyServer_1New(JNIEnv *jenv, jclass jcls, jlong jarg1, jlong jarg3) {
  ServerDef *arg1 = 0 ;
  std::unique_ptr< tensorflow::ServerInterface > *arg2 = (std::unique_ptr< tensorflow::ServerInterface > *) 0 ;
  TF_Status *arg3 = (TF_Status *) 0 ;
  tensorflow::ServerDef temp1 ;
  std::unique_ptr< tensorflow::ServerInterface > temp2 ;
  
  (void)jenv;
  (void)jcls;
  {
    arg2 = &temp2;
  }
  {
    char* c_string;
    Py_ssize_t py_size;
    if (PyBytes_AsStringAndSize(jarg1, &c_string, &py_size) == -1) {
      // Python has raised an error (likely TypeError or UnicodeEncodeError).
      SWIG_fail;
    }
    
    if (!temp1.ParseFromString(string(c_string, py_size))) {
      PyErr_SetString(
        PyExc_TypeError,
        "The ServerDef could not be parsed as a valid protocol buffer");
      SWIG_fail;
    }
    arg1 = &temp1;
  }
  arg3 = *(TF_Status **)&jarg3; 
  PyServer_New((ServerDef const &)*arg1,arg2,arg3);
  {
    // TODO(mrry): Convert this to SWIG_POINTER_OWN when the issues with freeing
    // a server are fixed.
    jresult = SWIG_NewPointerObj(arg2->release(),
      SWIGTYPE_p_tensorflow__ServerInterface,
      0);
  }
}


SWIGEXPORT void JNICALL Java_server_1libJNI_PyServer_1Start(JNIEnv *jenv, jclass jcls, jlong jarg1, jlong jarg2) {
  tensorflow::ServerInterface *arg1 = (tensorflow::ServerInterface *) 0 ;
  TF_Status *arg2 = (TF_Status *) 0 ;
  
  (void)jenv;
  (void)jcls;
  arg1 = *(tensorflow::ServerInterface **)&jarg1; 
  arg2 = *(TF_Status **)&jarg2; 
  PyServer_Start(arg1,arg2);
}


SWIGEXPORT void JNICALL Java_server_1libJNI_PyServer_1Stop(JNIEnv *jenv, jclass jcls, jlong jarg1, jlong jarg2) {
  tensorflow::ServerInterface *arg1 = (tensorflow::ServerInterface *) 0 ;
  TF_Status *arg2 = (TF_Status *) 0 ;
  
  (void)jenv;
  (void)jcls;
  arg1 = *(tensorflow::ServerInterface **)&jarg1; 
  arg2 = *(TF_Status **)&jarg2; 
  PyServer_Stop(arg1,arg2);
}


SWIGEXPORT void JNICALL Java_server_1libJNI_PyServer_1Join(JNIEnv *jenv, jclass jcls, jlong jarg1, jlong jarg2) {
  tensorflow::ServerInterface *arg1 = (tensorflow::ServerInterface *) 0 ;
  TF_Status *arg2 = (TF_Status *) 0 ;
  
  (void)jenv;
  (void)jcls;
  arg1 = *(tensorflow::ServerInterface **)&jarg1; 
  arg2 = *(TF_Status **)&jarg2; 
  PyServer_Join(arg1,arg2);
}


SWIGEXPORT void JNICALL Java_server_1libJNI_tensorflow_1set(JNIEnv *jenv, jclass jcls, jlong jarg1) {
  namespace arg1 ;
  namespace *argp1 ;
  
  (void)jenv;
  (void)jcls;
  argp1 = *(namespace **)&jarg1; 
  if (!argp1) {
    SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "Attempt to dereference null namespace");
    return ;
  }
  arg1 = *argp1; 
  tensorflow = arg1;
}


SWIGEXPORT jlong JNICALL Java_server_1libJNI_tensorflow_1get(JNIEnv *jenv, jclass jcls) {
  jlong jresult = 0 ;
  namespace result;
  
  (void)jenv;
  (void)jcls;
  result = tensorflow;
  {
    namespace * resultptr = (namespace *) malloc(sizeof(namespace));
    memmove(resultptr, &result, sizeof(namespace));
    *(namespace **)&jresult = resultptr;
  }
  return jresult;
}


#ifdef __cplusplus
}
#endif
