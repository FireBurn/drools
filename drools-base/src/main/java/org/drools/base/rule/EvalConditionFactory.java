/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.base.rule;

import org.kie.api.internal.utils.KieService;

public interface EvalConditionFactory extends KieService {

    EvalCondition createEvalCondition(final Declaration[] requiredDeclarations);

    class Factory {

        private static class LazyHolder {

            private static final EvalConditionFactory INSTANCE = createInstance();

            private static EvalConditionFactory createInstance() {
                EvalConditionFactory factory = KieService.load(EvalConditionFactory.class);
                return factory != null ? factory : new EvalConditionFactoryImpl();
            }
        }

        public static EvalConditionFactory get() {
            return LazyHolder.INSTANCE;
        }

        private Factory() {}
    }
}