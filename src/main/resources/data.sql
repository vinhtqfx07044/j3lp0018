INSERT INTO
  about_me (id, content, image_path, author)
VALUES
  (
    1,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.',
    'i5.jpg',
    'Susan Stratton'
  );

INSERT INTO
  post (
    title,
    type,
    content,
    image_path,
    created_at,
    num_likes,
    num_comments
  )
VALUES
  (
    'In New York',
    'photo',
    'Claritas est etiam processus dynamicus, qui sequitur',
    'i1.jpg',
    '2014-08-17'::DATE,
    5,
    2
  ),
  (
    'In New York',
    'blog',
    'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. 
Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. 
Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. 
Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.',
    'i2.jpg',
    '2014-08-17'::DATE,
    6,
    7
  ),
  (
    'Awesome Gucci',
    'photo',
    'Claritas est etiam processus dynamicus, qui sequitur',
    'i3.jpg',
    '2014-08-17'::DATE,
    2,
    0
  ),
  (
    'Special Offer',
    'photo',
    'Claritas est etiam processus dynamicus, qui sequitur',
    'i4.jpg',
    '2014-08-17'::DATE,
    1,
    1
  );

INSERT INTO
  social (name, icon)
VALUES
  ('Facebook', 'fb.jpg'),
  ('Twitter', 'tw.jpg'),
  ('Google+', 'gg.jpg');

INSERT INTO
  total_views (id, view_count)
VALUES
  (1, 0);