/**
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
package org.apache.pinot.core.query.aggregation;

import org.apache.pinot.core.query.aggregation.function.AggregationFunction;


/**
 * This class caches miscellaneous data to perform efficient aggregation.
 */
public class AggregationFunctionContext {
  private final AggregationFunction _aggregationFunction;
  private final String _column;

  public AggregationFunctionContext(AggregationFunction aggregationFunction, String column) {
    _aggregationFunction = aggregationFunction;
    _column = column;
  }

  /**
   * Returns the aggregation function.
   */
  public AggregationFunction getAggregationFunction() {
    return _aggregationFunction;
  }

  /**
   * Returns the aggregation column (could be column name or UDF expression).
   */
  public String getColumn() {
    return _column;
  }

  /**
   * Returns the aggregation column name for the results.
   * <p>E.g. AVG(foo) -> avg_foo
   */
  public String getAggregationColumnName() {
    return _aggregationFunction.getColumnName(_column);
  }

  /**
   * Returns the aggregation column name for the result table.
   * <p>E.g. AVGMV(foo) -> avgMV(foo)
   */
  public String getResultColumnName() {
    return _aggregationFunction.getResultColumnName(_column);
  }
}
