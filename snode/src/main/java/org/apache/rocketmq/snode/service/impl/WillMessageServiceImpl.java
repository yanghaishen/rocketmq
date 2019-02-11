/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.snode.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import org.apache.rocketmq.common.message.mqtt.WillMessage;
import org.apache.rocketmq.snode.SnodeController;
import org.apache.rocketmq.snode.service.WillMessageService;

public class WillMessageServiceImpl implements WillMessageService {

    private static ConcurrentHashMap<String/*clientId*/, WillMessage> willMessageTable = new ConcurrentHashMap<>();
    private final SnodeController snodeController;

    public WillMessageServiceImpl(SnodeController snodeController) {
        this.snodeController = snodeController;
    }

    @Override
    public void saveWillMessage(String clientId, WillMessage willMessage) {
        willMessageTable.put(clientId, willMessage);
    }

    @Override
    public void sendWillMessage(String clientId) {

    }

    @Override
    public void deleteWillMessage(String clientId) {
        willMessageTable.remove(clientId);
    }
}
