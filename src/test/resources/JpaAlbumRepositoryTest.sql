insert into artiesten values
(null, 'TestArtiest');
insert into albums values
(null, (select id from artiesten a where a.naam = 'TestArtiest'), 'TestAlbum',1234, 1, 5);
insert into tracks values
((select a.id from albums a where a.naam = 'TestAlbum'), 'TestTrack', 12.45)