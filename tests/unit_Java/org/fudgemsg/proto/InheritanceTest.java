/*
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fudgemsg.proto;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.fudgemsg.FudgeContext;
import org.fudgemsg.FudgeMsg;
import org.fudgemsg.mapping.FudgeDeserializer;
import org.fudgemsg.mapping.FudgeSerializer;
import org.fudgemsg.proto.tests.inheritance.BaseClassA;
import org.fudgemsg.proto.tests.inheritance.BaseClassB;
import org.fudgemsg.proto.tests.inheritance.SubClassA;
import org.fudgemsg.proto.tests.inheritance.SubClassA2;
import org.junit.Test;

public class InheritanceTest {
  
  private static final List<Integer> INT_LIST = new ArrayList<Integer> (); 
    
  static {
    INT_LIST.add (42);
  }
  
  @Test
  public void testBaseClassA () {
    BaseClassA bcA = new BaseClassA.Builder (1, INT_LIST).build ();
    FudgeMsg m = bcA.toFudgeMsg(new FudgeSerializer(FudgeContext.GLOBAL_DEFAULT));
    System.out.println (m);
    bcA = BaseClassA.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m);
    assertNotNull (bcA);
  }
  
  @Test
  public void testBaseClassB () {
    BaseClassB bcB = new BaseClassB.Builder (2, INT_LIST).build ();
    FudgeMsg m = bcB.toFudgeMsg(new FudgeSerializer(FudgeContext.GLOBAL_DEFAULT));
    System.out.println (m);
    bcB = BaseClassB.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m);
    assertNotNull (bcB);
  }
  
  @Test
  public void testSubClassA () {
    SubClassA scA = new SubClassA.Builder(INT_LIST, 3, INT_LIST).build();
    FudgeMsg m = scA.toFudgeMsg(new FudgeSerializer(FudgeContext.GLOBAL_DEFAULT));
    System.out.println (m);
    scA = SubClassA.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m);
    assertNotNull (scA);
    assertNotNull(BaseClassA.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m));
  }
  
  @Test
  public void testSubClassA2 () {
    SubClassA2 scA2 = new SubClassA2.Builder(INT_LIST, 3, INT_LIST, 5, INT_LIST).build();
    FudgeMsg m = scA2.toFudgeMsg(new FudgeSerializer(FudgeContext.GLOBAL_DEFAULT));
    System.out.println (m);
    scA2 = SubClassA2.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m);
    assertNotNull (scA2);
    assertNotNull(SubClassA.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m));
    assertNotNull(BaseClassA.fromFudgeMsg(new FudgeDeserializer(FudgeContext.GLOBAL_DEFAULT), m));
  }
  
}