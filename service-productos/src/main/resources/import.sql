USE [db_service_producto]

SET IDENTITY_INSERT [dbo].[producto] ON 
INSERT [dbo].[producto] ([producto_id], [nombre], [activo]) VALUES (1, 'BOLETAS', 1)
INSERT [dbo].[producto] ([producto_id], [nombre], [activo]) VALUES (2, 'FILES', 1)
INSERT [dbo].[producto] ([producto_id], [nombre], [activo]) VALUES (3, 'FACTURA', 1)
SET IDENTITY_INSERT [dbo].[producto] OFF