USE [Player]
GO

/****** Object:  Table [dbo].[player]    Script Date: 04/23/2018 16:06:23 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[player](
	[name] [char](10) NOT NULL,
	[time] [char](10) NULL,
	[score] [int] NOT NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[player] ADD  CONSTRAINT [DF_player_score]  DEFAULT ((0)) FOR [score]
GO

