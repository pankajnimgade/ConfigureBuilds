/*
 * Copyright 2018 Pankaj Nimgade
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package configure.test.configurebuilds.test;

/**
 * Created by Pankaj Nimgade on 8/5/2018.
 */

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "features",
        glue = {"configure.test.configurebuilds.test"},
        monochrome = true,
        plugin = {"pretty"})
public class CucumberRunner {
}
