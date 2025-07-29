INSERT INTO
  about_me (`id`, `content`, `image_path`, `author`)
VALUES
  (
    1,
    N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.',
    N'i5.jpg',
    N'Susan Stratton'
  );

INSERT INTO
  `post` (
    `title`,
    `type`,
    `content`,
    `image_path`,
    `created_at`,
    `num_likes`,
    `num_comments`
  )
VALUES
  (
    N'In New York',
    N'photo',
    N'Claritas est etiam processus dynamicus, qui sequitur',
    N'i1.jpg',
    CAST(N'2014-08-17' AS DATE),
    5,
    2
  ),
  (
    N'In New York',
    N'blog',
    N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. 
Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. 
Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. 
Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.',
    N'i2.jpg',
    CAST(N'2014-08-17' AS DATE),
    6,
    7
  ),
  (
    N'Awesome Gucci',
    N'photo',
    N'Claritas est etiam processus dynamicus, qui sequitur',
    N'i3.jpg',
    CAST(N'2014-08-17' AS DATE),
    2,
    0
  ),
  (
    N'Special Offer',
    N'photo',
    N'Claritas est etiam processus dynamicus, qui sequitur',
    N'i4.jpg',
    CAST(N'2014-08-17' AS DATE),
    1,
    1
  );

INSERT INTO
  `social` (`name`, `icon`)
VALUES
  (N'Facebook', N'fb.jpg'),
  (N'Twitter', N'tw.jpg'),
  (N'Google+', N'gg.jpg');

INSERT INTO
  `total_views` (`id`, `view_count`)
VALUES
  (1, 0);