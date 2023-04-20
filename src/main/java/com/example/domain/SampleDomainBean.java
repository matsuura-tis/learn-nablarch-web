package com.example.domain;

import nablarch.core.validation.ee.Length;
import nablarch.core.validation.ee.SystemChar;

/**
 * ドメイン定義。
 */
public class SampleDomainBean {

    /**
     * ドメイン定義の例。
     */
    @SystemChar(charsetDef = "システム許容文字")
    @Length(min = 3, max = 5)
    public String exampleDomain;

    @SystemChar(charsetDef = "半角英数")
    @Length(min = 1, max = 20)
    public String loginId;

    @SystemChar(charsetDef = "ASCII文字")
    @Length(min = 1, max = 64)
    public String password;
}
