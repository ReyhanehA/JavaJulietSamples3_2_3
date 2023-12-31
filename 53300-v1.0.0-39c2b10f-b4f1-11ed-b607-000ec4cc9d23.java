/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__Environment_divide_68a.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-68a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__Environment_divide_68a extends AbstractTestCase
{

    public static int data;

    public void bad() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        (new CWE369_Divide_By_Zero__Environment_divide_68b()).bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        (new CWE369_Divide_By_Zero__Environment_divide_68b()).goodG2B_sink();
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        (new CWE369_Divide_By_Zero__Environment_divide_68b()).goodB2G_sink();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
