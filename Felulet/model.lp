\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj: lambda_0 + lambda_1
Subject To
 c1:  x_(0_0_0_1)_(0_0) + x_(0_0_0_1)_(0_1) + x_(0_0_0_1)_(1_0)
      + x_(0_0_0_1)_(1_1) - 100000 y_0_0_0_1 <= 0
 c3:  y_0_0_0_1 - z_0_0_0  = 0
 c5:  z_0_0_0 - 100000 q_0_0 <= 0
 c7:  x_(0_1_0_0)_(0_0) + x_(0_1_0_0)_(1_0) - 100000 y_0_1_0_0 <= 0
 c9:  y_0_1_0_0 - z_0_1_0  = 0
 c11: z_0_1_0 - 100000 q_0_1 <= 0
 c13: q_0_0 + q_0_1 <= 1
 c15: x_(1_0_0_1)_(0_0) + x_(1_0_0_1)_(0_1) + x_(1_0_0_1)_(1_0)
      + x_(1_0_0_1)_(1_1) - 100000 y_1_0_0_1 <= 0
 c17: y_1_0_0_1 - z_1_0_0  = 0
 c19: z_1_0_0 - 100000 q_1_0 <= 0
 c21: x_(1_1_0_0)_(0_0) + x_(1_1_0_0)_(1_0) - 100000 y_1_1_0_0 <= 0
 c23: y_1_1_0_0 - z_1_1_0  = 0
 c25: z_1_1_0 - 100000 q_1_1 <= 0
 c26: q_1_0 + q_1_1 <= 1
 c27: x_(0_0_0_1)_(0_0) + x_(0_1_0_0)_(0_0) + x_(1_0_0_1)_(0_0)
      + x_(1_1_0_0)_(0_0)  = 2
 c28: x_(0_0_0_1)_(1_0) + x_(0_1_0_0)_(1_0) + x_(1_0_0_1)_(1_0)
      + x_(1_1_0_0)_(1_0)  = 1
 c29: x_(0_0_0_1)_(0_1) + x_(1_0_0_1)_(0_1)  = 0
 c30: x_(0_0_0_1)_(1_1) + x_(1_0_0_1)_(1_1)  = 2
 c31: x_(0_0_0_1)_(0_0) + x_(0_0_0_1)_(1_0) + x_(0_1_0_0)_(0_0)
      + x_(0_1_0_0)_(1_0) - 100000 c_0_0 <= 0
 c32: x_(0_0_0_1)_(0_1) + x_(0_0_0_1)_(1_1) - 100000 c_0_1 <= 0
 c33: c_0_0 + c_0_1 <= 2
 c34: x_(1_0_0_1)_(0_0) + x_(1_0_0_1)_(1_0) + x_(1_1_0_0)_(0_0)
      + x_(1_1_0_0)_(1_0) - 100000 c_1_0 <= 0
 c35: x_(1_0_0_1)_(0_1) + x_(1_0_0_1)_(1_1) - 100000 c_1_1 <= 0
 c36: c_1_0 + c_1_1 <= 2
 c37: x_(0_0_0_1)_(0_0) + x_(0_0_0_1)_(0_1) - cycle_0_0 <= 0
 c38: x_(0_1_0_0)_(0_0) - cycle_0_0 <= 0
 c39: x_(0_0_0_1)_(1_0) + x_(0_0_0_1)_(1_1) - cycle_0_1 <= 0
 c40: x_(0_1_0_0)_(1_0) - cycle_0_1 <= 0
 c41: x_(1_0_0_1)_(0_0) + x_(1_0_0_1)_(0_1) - cycle_1_0 <= 0
 c42: x_(1_1_0_0)_(0_0) - cycle_1_0 <= 0
 c43: x_(1_0_0_1)_(1_0) + x_(1_0_0_1)_(1_1) - cycle_1_1 <= 0
 c44: x_(1_1_0_0)_(1_0) - cycle_1_1 <= 0
 c45: x_(0_0_0_1)_(0_0) + x_(0_0_0_1)_(0_1) + x_(0_1_0_0)_(0_0) + cycle_0_0
      - lambda_0 <= 0
 c46: x_(1_0_0_1)_(0_0) + x_(1_0_0_1)_(0_1) + x_(1_1_0_0)_(0_0) + cycle_1_0
      - lambda_0 <= 0
 c47: x_(0_0_0_1)_(1_0) + x_(0_0_0_1)_(1_1) + x_(0_1_0_0)_(1_0) + cycle_0_1
      - lambda_1 <= 0
 c48: x_(1_0_0_1)_(1_0) + x_(1_0_0_1)_(1_1) + x_(1_1_0_0)_(1_0) + cycle_1_1
      - lambda_1 <= 0
Bounds
 0 <= x_(0_0_0_1)_(0_0) <= 2
      x_(0_0_0_1)_(0_1) = 0
 0 <= x_(0_0_0_1)_(1_0) <= 1
 0 <= x_(0_0_0_1)_(1_1) <= 2
 0 <= x_(0_1_0_0)_(0_0) <= 2
 0 <= x_(0_1_0_0)_(1_0) <= 1
 0 <= x_(1_0_0_1)_(0_0) <= 2
      x_(1_0_0_1)_(0_1) = 0
 0 <= x_(1_0_0_1)_(1_0) <= 1
 0 <= x_(1_0_0_1)_(1_1) <= 2
 0 <= x_(1_1_0_0)_(0_0) <= 2
 0 <= x_(1_1_0_0)_(1_0) <= 1
 0 <= y_0_0_0_1 <= 1
 0 <= y_0_1_0_0 <= 1
 0 <= y_1_0_0_1 <= 1
 0 <= y_1_1_0_0 <= 1
 0 <= z_0_0_0 <= 1
 0 <= z_0_1_0 <= 1
 0 <= z_1_0_0 <= 1
 0 <= z_1_1_0 <= 1
 0 <= q_0_0 <= 1
 0 <= q_0_1 <= 1
 0 <= q_1_0 <= 1
 0 <= q_1_1 <= 1
 0 <= c_0_0 <= 1
 0 <= c_0_1 <= 1
 0 <= c_1_0 <= 1
 0 <= c_1_1 <= 1
 0 <= cycle_0_0 <= 2147483647
 0 <= cycle_0_1 <= 2147483647
 0 <= cycle_1_0 <= 2147483647
 0 <= cycle_1_1 <= 2147483647
 0 <= lambda_0 <= 2147483647
 0 <= lambda_1 <= 2147483647
Generals
 x_(0_0_0_1)_(0_0)  x_(0_0_0_1)_(0_1)  x_(0_0_0_1)_(1_0)  x_(0_0_0_1)_(1_1) 
 x_(0_1_0_0)_(0_0)  x_(0_1_0_0)_(1_0)  x_(1_0_0_1)_(0_0)  x_(1_0_0_1)_(0_1) 
 x_(1_0_0_1)_(1_0)  x_(1_0_0_1)_(1_1)  x_(1_1_0_0)_(0_0)  x_(1_1_0_0)_(1_0) 
 y_0_0_0_1  y_0_1_0_0  y_1_0_0_1  y_1_1_0_0  z_0_0_0  z_0_1_0  z_1_0_0 
 z_1_1_0  q_0_0  q_0_1  q_1_0  q_1_1  c_0_0  c_0_1  c_1_0  c_1_1  cycle_0_0 
 cycle_0_1  cycle_1_0  cycle_1_1  lambda_0  lambda_1 
End
