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

import java.io.IOException;

/**
 * Abstract interface for locating program source for a given identifier. 
 * 
 * @author Andrew
 */
public interface SourceResolver {
  
  /**
   * Returns a Source object that contains a given definition (e.g. based on filesystem conventions), or null
   * if there is none available.
   */
  public Source findSource (final String identifier) throws IOException;

}