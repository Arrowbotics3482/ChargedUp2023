from networktables import NetworkTables

table = NetworkTables.getTable("limelight")

tx = table.getNumber('tx',None)
ty = table.getNumber('ty',None)
ta = table.getNumber('ta',None)
ts = table.getNumber('ts',None)

print(tx)
print(ty)
print(ta)
print(ts)

#NetworkTables.getTable("limelight").getNumber('tx');

