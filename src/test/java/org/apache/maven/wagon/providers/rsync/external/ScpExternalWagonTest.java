package org.apache.maven.wagon.providers.rsync.external;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;

import org.apache.maven.wagon.WagonConstants;
import org.apache.maven.wagon.WagonTestCase;
import org.apache.maven.wagon.authentication.AuthenticationInfo;
import org.apache.maven.wagon.repository.Repository;
import org.apache.maven.wagon.resource.Resource;

/**
 * @author <a href="michal.maczka@dimatics.com">Michal Maczka</a>
 *
 */
public class ScpExternalWagonTest
    extends WagonTestCase
{
    protected int getExpectedContentLengthOnGet( int expectedSize )
    {
        return WagonConstants.UNKNOWN_LENGTH;
    }

    protected boolean supportsGetIfNewer()
    {
        return false;
    }

    protected long getExpectedLastModifiedOnGet( Repository repository, Resource resource )
    {
        return 0;
    }

    protected String getProtocol()
    {
        return "scpexe";
    }

    public String getTestRepositoryUrl()
    {
        return TestData.getTestRepositoryUrl(this.getProtocol());
    }

    protected AuthenticationInfo getAuthInfo()
    {
        AuthenticationInfo authInfo = new AuthenticationInfo();

        String userName = TestData.getUserName();

        authInfo.setUserName( userName );

        File privateKey = TestData.getPrivateKey();

        if ( privateKey.exists() )
        {
            authInfo.setPrivateKey( privateKey.getAbsolutePath() );

            authInfo.setPassphrase( "" );
        }

        return authInfo;
    }
}
