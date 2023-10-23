create table if not exists review(
    id uuid primary key default gen_random_uuid(),
    order_id text not null unique,
    partner_id text not null,
    customer_id text not null,
    score int not null,
    created_at timestamp without time zone default now()
);