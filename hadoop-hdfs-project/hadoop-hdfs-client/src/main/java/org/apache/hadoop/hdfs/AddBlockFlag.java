/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.CreateFlag;

/**
 * AddBlockFlag provides hints for new block allocation and placement.
 * Users can use this flag to control <em>per DFSOutputStream</em>
 * {@see ClientProtocol#addBlock()} behavior.
 */
@InterfaceAudience.Private
@InterfaceStability.Evolving
public enum AddBlockFlag {

  /**
   * Advise that a block replica NOT be written to the local DataNode where
   * 'local' means the same host as the client is being run on.
   *
   * @see CreateFlag#NO_LOCAL_WRITE
   */
  NO_LOCAL_WRITE((short) 0x01);

  private final short mode;

  AddBlockFlag(short mode) {
    this.mode = mode;
  }

  public static AddBlockFlag valueOf(short mode) {
    for (AddBlockFlag flag : AddBlockFlag.values()) {
      if (flag.getMode() == mode) {
        return flag;
      }
    }
    return null;
  }

  public short getMode() {
    return mode;
  }
}
